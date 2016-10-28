(ns ex-compass.android.core
  (:require-macros [natal-shell.components :refer [status-bar view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [re-natal.support :as sup]
            [ex-compass.shared.react.requires :refer [createRouter]]
            [ex-compass.shared.react.helpers :refer [nav-provider]]
            [ex-compass.shared.state :as state]
            [ex-compass.shared.drawer :refer [drawer]]))


(def routes {:home {:initialRoute :tab1 :tab1 Home :tab2 Foo}
             :about {:initialRoute :tab2 :tab1 Foo :tab2 About}})

(def app-registry (.-AppRegistry js/ReactNative))


(defui AppRoot
  static om/IQuery
  (query [_] '[:nav/root])

  Object
  (render [this]
          (nav-provider {:router (createRouter (fn [] #js {}))}
                        (status-bar {:key "status-bar" :hidden false :barStyle "light-content"})
                        (drawer {:key "drawer" :routes routes}))))

(defonce RootNode (sup/root-node! 1))
(defonce app-root (om/factory RootNode))

(defn init []
      (om/add-root! state/reconciler AppRoot 1)
      (.registerComponent app-registry "Ex-Compass" (fn [] app-root)))
