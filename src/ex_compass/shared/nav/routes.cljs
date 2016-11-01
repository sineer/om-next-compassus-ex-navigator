(ns ex-compass.shared.nav.routes
  (:require [sw.shared.tabs :refer [HomeNav AboutNav Home Foo About]]))

(def compass {:nav/root nil
              :nav/home HomeNav
              :nav/about AboutNav
              :home/home Home
              :home/foo Foo
              :about/about About
              :about/foo Foo})

(def drawers {:home :nav/home
              :about :nav/about})

(def tabs {:home [:home/home :home/foo]
           :about [:about/about :about/foo]})
