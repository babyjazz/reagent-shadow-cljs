(ns starter.core
  (:require [reagent.core :as r]
            [starter.home :refer [Home]]
            [starter.about :refer [About]]
            ["react-router-dom" :refer (Route Link BrowserRouter)]
            ["react-helmet" :default Helmet]))

(def rt (r/adapt-react-class Route))

(defn app []
  [:div
   [:> Helmet
    [:title "Example of using reagent with shadow"]]
   [:> BrowserRouter
    [rt {:path "/" :exact true :component #(r/as-element [Home])}]
    [rt {:path "/about" :component #(r/as-element [About])}]]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (start))
