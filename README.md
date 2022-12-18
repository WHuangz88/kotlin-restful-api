# API Spec

## Authentication

All API must use this authentication

Request:
- Header:
  - X-Api-Key: "your secret api key"

## Create Product

Request :
- Method: POST
- Endpoint : `/api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json
{
  "id" : "string, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id" : "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "created_at": "date",
    "updated_at": "date"
  }
}
```

## Get Product

Request :
- Method: GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept: application/json
Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id" : "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "created_at": "date",
    "updated_at": "date"
  }
}
```

## Update Product

Request :
- Method: PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "id" : "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "created_at": "date",
    "updated_at": "date"
  }
}
```

## List Product

Request :
- Method: GET
- Endpoint : `/api/products`
- Header :
    - Accept: application/json
    - Content-Type: application/json
- Query Param:
    - size: number,
    - page: number
Response:
```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "id" : "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "created_at": "date",
      "updated_at": "date"
    }
  ]
}
```

## Delete Product

Request :
- Method: DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
    - Accept: application/json

Response:
```json
```