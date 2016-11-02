(ns ex-compass.shared.nav.sight
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.react.helpers :refer [stack-nav]]))


(defui Sight
  Object
  (initLocalState [this]
                  (let [props (om/props this)
                        {:keys [:id :routes]} props]
                    {:id id
                     :routes routes
                     :current-route (first routes)}))

  (render [this]
          (let [state (om/get-state this)
                id (:id state)
                current-route (:current-route state)
                factory (om/factory current-route {:keyfn :key})
                index-thunk ((fn [] (fn [] (factory {:key id}))))]
            (stack-nav {:key (str id "-nav") :navigatorUID id :initialRoute index-thunk}))))

(def sight (om/factory Sight {:keyfn :id}))
