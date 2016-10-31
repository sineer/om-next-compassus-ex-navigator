(ns ex-compass.shared.react.requires)


(set! js/window.React (js/require "react"))
(def ReactNative (js/require "react-native"))

;; @exponent/ex-navigation
(defonce ExNavigation (js/require "@exponent/ex-navigation"))
(defonce createRouter (aget ExNavigation "createRouter"))
(defonce NavigationStyles (aget ExNavigation "NavigationStyles"))
(defonce NavigationProvider (.-default (js/require "@exponent/ex-navigation/src/ExNavigationProvider.js")))
(defonce NavigationActions (.-default (js/require "@exponent/ex-navigation/src/ExNavigationActions.js")))
(defonce StackNavigation (.-default (js/require "@exponent/ex-navigation/src/ExNavigationStack.js")))
(defonce DrawerNavigation (.-default (js/require "@exponent/ex-navigation/src/drawer/ExNavigationDrawer.js")))
(defonce DrawerNavigationItem (.-default (js/require "@exponent/ex-navigation/src/drawer/ExNavigationDrawerItem.js")))
(defonce TabNavigation (.-default (js/require "@exponent/ex-navigation/src/tab/ExNavigationTab.js")))
(defonce TabNavigationItem (.-default (js/require "@exponent/ex-navigation/src/tab/ExNavigationTabItem.js")))
