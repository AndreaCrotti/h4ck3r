(ns h4ck3r.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.data.json :as json]
            [ring.middleware.json :refer [wrap-json-params]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.util.response :as resp]
            [ring.swagger.swagger2 :as rs]
            [schema.core :as s]
            [selmer.parser :as selmer]
            [h4ck3r.core :refer [convert]]))

;;TODO: use this for validation
(s/defschema Query {:message s/Str
                    })

#_(s/with-fn-validation 
  (rs/swagger-json 
    {:info {:version "1.0.0"
            :title "Message"
            :description "Message to enter"
            :termsOfService "http://helloreverb.com/terms/"
            :contact {:name "H4ck3r"
                      :email "andrea.crotti.0@gmail.com"
                      :url "https://github.com/AndreaCrotti/h4ck3r"}
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}}
     :tags [{:name "user"
             :description "User stuff"}]
     :paths {"/translate/" {:post {:summary "Translation API"
                                   :description "Translate"
                                   :tags ["text"]
                                   :parameters {:body Query}
                                   :responses {201 {:schema Query
                                                    :description "Found it!"}}}}}}))


(defn translate [params]
  "Translate string returning content"
  (let [res (convert (:message params) :trim)]
    {:status 201
     :headers {"Content-Type" "application/json"}
     :body (json/write-str res)}))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/translate"))
  (GET "/translate" [] (selmer/render-file "index.html" {}))
  (POST "/translate" params
        (let [response (translate (:params params))
              parsed (json/read-str (:body response))]
          (println "keys are equal to" (keys parsed))
          (println "res equal to " (:shortened parsed))
          (selmer/render-file "index.html" {:result (get "shortened" (:body response))})))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes api-defaults))
