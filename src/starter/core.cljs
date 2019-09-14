(ns starter.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [starter.home :refer [Home]]
            [starter.store :as state]
            [starter.reframe-example :refer [ReframeExample]]))

(defn app []
  [:div
   [Home]
   [ReframeExample]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (rf/dispatch-sync [:initialize]) ; :initialize from global_state file. Define before app start
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (start))
