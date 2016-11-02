(ns ^:figwheel-no-load env.ios.main
  (:require [om.next :as om]
            [ex-compass.android.core :as core]
            [ex-compass.shared.nav.nav-compass :refer [nav-reset!]]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws"
  :heads-up-display false
  :jsload-callback #(nav-reset!))

(core/init)
