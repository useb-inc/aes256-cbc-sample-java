HOW TO BUILD 
> gradle build

HOW TO RUN TESTS
> gradle test

HOW TO RUN MAIN FUNCTION 
>  java -jar "build\libs\aes256-cbc-java-1.0-SNAPSHOT.jar"

Output Sample
```output
encrypted = Zlgcl/3jVggxBxWjWXC5je/hZ/HBGQ7dvPLQqotjRLCqMTDqIhvOmjg79+NhBj+rlxe0Oo2NWpg3FpxkpqiCKSBJqgduAXp3jZz7O1/Jvw4OgNYLCTNLZaUcI6s33akkUWucv8OHgbl3C1E7HoFSHpQnF/CFMaQGOxVmJWgy2o5AkAeuWSGS4N9SP9KDYZwZPhhcmbcoVGoUxSmMZ5utrlaivu+ASi1CXjsSMFzCVgR82RV297wAEaaJO0JbJqM1ffd3fir0fK2IWTGHskQbqw==
decrypted = {"idType":"2","userName":"홍길동","driverNo":"13-03-123456-11","juminNo1":"910101","juminNo2":"1001234","_juminNo2":"1******","issueDate":"20170131","transaction_id":"14740463576391927d859b91670484605"}
decrypted from file(test/resources/encrypted.txt){"idType":"2","userName":"홍길동","driverNo":"13-03-123456-11","juminNo1":"910101","juminNo2":"1001234","_juminNo2":"1******","issueDate":"20170131","transaction_id":"14740463576391927d859b91670484605"}
```

