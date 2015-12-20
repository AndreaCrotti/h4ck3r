(ns h4ck3r.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [h4ck3r.core :refer [convert]]))

(defn translate [params]
  "Translate string returning content"
  (let [res (convert (:message params) :trim)]
    {:status 201
     :headers {"Content-Type" "application/json"}
     :body (json/write-str res)}))

(defroutes app-routes
  (GET "/" [] "Welcome to the H4ck3r project")
  (POST "/translate" params (translate (:params params)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
