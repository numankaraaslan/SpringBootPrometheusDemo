http://prometheus:9090

seq 1 25000 | xargs -n1 -P1000 -I{} \
curl -s -X POST http://localhost:8080/books/save \
  -H "Content-Type: application/json" \
  -d '{"name":"The Name of the Wind","isbn":"978-0000000022","year":2007,"author":"Patrick Rothfuss"}'
