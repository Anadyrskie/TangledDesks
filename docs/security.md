The server is addressed with a basic POST request, constructed as such:
  
      POST /test HTTP/1.1
      Host: foo.example
      Content-Type: application/x-www-form-urlencoded {
      "type=login&username=user&password=pass"
      }
  
  
  It returns a JSON object populated with the userID and the API key.

