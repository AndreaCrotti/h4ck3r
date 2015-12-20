(ns h4ck3r.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure.data.json :as json]
            [h4ck3r.handler :refer :all]))

(def desired
  (json/write-str {:mapping {"Hello" "He", "world" "wo"}
                   :shortened "He wo"}))

(deftest test-app
  (testing "translator"
    (let [response (app (mock/request :post "/translate" {:message "Hello world"}))]
      (is (= 200 (:status response)))
      (is (= desired (:body response)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
