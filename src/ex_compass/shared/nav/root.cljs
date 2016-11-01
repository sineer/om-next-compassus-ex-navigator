(ns ex-compass.shared.nav.root
  (:require-macros [natal-shell.components :refer [status-bar]])
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.react.requires :refer [createRouter]]
            [ex-compass.shared.react.helpers :refer [nav-provider]]
            [ex-compass.shared.nav.drawer :refer [drawer]]))

(defui NavRoot
  static om/IQuery
  (query [_] `[{:nav/root ~(om/query nav/NavRoot)}])

  Object
  ;; (initLocalState [this]
  ;;                 {:compass (compass {key "compass"})})

  ;; (componentWillMount [this]
  ;;                     (let [c (compass {key "compass"})]
  ;;                       (om/update-state! this assoc :compass c)))

  ;; (componentWillUnmount [this]
  ;;                       ;; Cleanup Compass ?
  ;;                       )

  (render [this]
            (nav-provider {:router (createRouter (fn [] #js {}))}
                          (status-bar {:key "status-bar" :hidden false :barStyle "light-content"})
                          (drawer {:key "left-drawer"}))))

(def nav-root (om/factory NavRoot {:keyfn :key}))
