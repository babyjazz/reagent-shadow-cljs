(ns starter.utils.fetch
  (:require [clojure.walk :refer [keywordize-keys]]
            [re-frame.core :as rf]
            [starter.constants.fetch-status :as status]))

(def method-map {"get" :get
                 "post" :post
                 "patch" :patch
                 "put" :put
                 "delete" :delete})


(defn fetch [url options]
  (rf/dispatch [:set-api {(get options :dispatch) {:status status/request}}])
  (-> (js/fetch url (clj->js {:method (get options :method)
                              :body (let [body (get options :body)]
                                      (when-not (nil? body)
                                        (js/JSON.stringify (clj->js (get options :body)))))
                              :headers (merge {"Content-Type" "application/json"}
                                              (get options :headers))}))
      (.then (fn [resp]
               (.json resp)))
      (.then (fn [resp]
               (let [resp (keywordize-keys (js->clj resp))]
                 (rf/dispatch [:set-api {(get options :dispatch) {:status status/success
                                                                  :data (get resp :data)}}]))))
      (.catch (fn [err]
                (let [err (keywordize-keys (js->clj err))]
                  (rf/dispatch [:set-api {(get options :dispatch) {:status status/failure
                                                                   :message (get err :message)}}]))))))
