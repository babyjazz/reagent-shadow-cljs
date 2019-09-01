(ns starter.core
    (:require [reagent.core :as r]
              [starter.home :refer [Home]]))

(defn app []
  [:div
   [Home]])

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (start))
