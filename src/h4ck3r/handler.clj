(ns h4ck3r.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [h4ck3r.core :refer [convert]]))

(defn translate [params]
  {:status 200
   :content (:shortened (convert (:message params) :trim))})

(defroutes app-routes
  (POST "/translate" params (translate (:params params)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
