(ns joodo.kuzushi.commands.server-spec
  (:use
    [speclj.core]
    [joodo.kuzushi.spec-helper]
    [joodo.kuzushi.commands.server]))

(describe "Server Command"

  (with-command-help)

  (it "parses no args"
    (should= {:port 8080 :address "127.0.0.1" :environment "development" :directory "."} (parse-args)))

  (it "parses the port arg"
    (should= 1234 (:port (parse-args "-p" "1234")))
    (should= 4321 (:port (parse-args "--port=4321"))))

  (it "parses the address arg"
    (should= "111.222.111.222" (:address (parse-args "-a" "111.222.111.222")))
    (should= "222.111.222.111" (:address (parse-args "--address=222.111.222.111"))))

  (it "parses the environment arg"
    (should= "production" (:environment (parse-args "-e" "production")))
    (should= "new" (:environment (parse-args "--environment=new"))))

  (it "parses the directory arg"
    (should= "one" (:directory (parse-args "-d" "one")))
    (should= "two" (:directory (parse-args "--directory=two"))))

  )

(run-specs)
