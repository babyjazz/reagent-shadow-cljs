(ns starter.core
  (:require
   [re-frame.core :as rf]
   [starter.reframe.store]
   [starter.reframe.events]
   [reagent.core :as r]
   [starter.home :refer [Home]]))

(defn app []
  (let [ready?  (re-frame.core/subscribe [:initialized?])]
    (if-not @ready?
      [:div "Loading ..."]
      [Home])))

(defn stop []
  (js/console.log "Stopping..."))

(defn start []
  (js/console.log "Starting...")
  (rf/dispatch [:initialize]) ; :initialize state. Define before app start
  (r/render [app]
            (.getElementById js/document "app")))

(defn ^:export init []
  (start))
