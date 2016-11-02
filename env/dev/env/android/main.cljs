(ns ^:figwheel-no-load env.android.main
  (:require [om.next :as om]
            [ex-compass.android.core :as core]
            [ex-compass.shared.nav.nav-compass :refer [nav-reset!]]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)
(println "enable-console-print!")
(figwheel/watch-and-reload
  :websocket-url "ws://192.168.2.123:3449/figwheel-ws"
  :heads-up-display false
  :jsload-callback #(nav-reset!))

(core/init)
