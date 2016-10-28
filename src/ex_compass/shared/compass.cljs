(ns ex-compass.shared.compass
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [compassus.core :as compassus]
            [ex-compass.shared.react.helpers :refer [stack-nav]]))


(defui Compass
  Object
  (initLocalState [this]
                  (let [props (om/props this)
                        {:keys [:config]} props
                        routes (:routes config)
                        index-route (:index-route config)
                        app-state (:app-state config)
                        read (:read config)
                        mutate (:mutate config)
                        route-dispatch (:route-dispatch config)
                        reconciler (om/reconciler
                                    {:state app-state ; TODO err.. hrmmm.... not so sure about that ???
                                     :parser (compassus/parser {:read read :mutate mutate :route-dispatch route-dispatch})})
                        compassus-app (compassus/application {:routes routes :index-route index-route :reconciler reconciler})]
                    {:id (:id config)
                     :index-route index-route
                     :routes routes
                     :app-state app-state
                     :read read
                     :mutate mutate
                     :route-dispatch route-dispatch
                     :compassus-app compassus-app}))

  (render [this]
          (let [state (om/get-state this)
                id (:id state)
                index-route (:index-route state)
                factory (om/factory index-route {:keyfn :key})
                index-thunk ((fn [] (fn [] (factory {:key id}))))]
            (stack-nav {:key (str id "-nav") :navigatorUID id :initialRoute index-thunk}))))

(def compass (om/factory Compass {:keyfn :id}))
