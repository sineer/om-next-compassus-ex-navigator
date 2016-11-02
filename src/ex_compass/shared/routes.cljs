(ns ex-compass.shared.routes
  (:require [ex-compass.shared.tabs :refer [HomeNav AboutNav Home Foo About]]))

(def compass {:app/android :nav/root
              :app/ios :nav/root

              :nav/root nil
              :nav/home HomeNav
              :nav/about AboutNav

              :home/home Home
              :home/foo Foo

              :about/about About
              :about/foo Foo})
