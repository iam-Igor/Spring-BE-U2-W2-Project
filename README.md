## Description

This is an api to fetch users

## Base URL

The base URL for all API requests is:

`https://localhost:<yourportnumber>/users`

## Endpoints

### `GET`

Returns a list of all users in the server.

### Parameters

- size (optional): The maximum number of users to return. Default is 10.
- page (optional): The page number to return. Default is 0.
- order(optional): The property for sorting the users, based on the user properties.

### Response

Returns a JSON object with the following properties:

- content: An array of user objects, each with the following properties:
    - id: The unique identifier of the user. (server generated)
    - name: The name of the user.
    - surname: The surname of the user.
    - username: The username of the user.
    - email: The email of the user.
    - avatarUrl: The avatar url of the user, by default is null, you can add an url later.

### Example

Request:

```
GET https://localhost:<yourportnumber>/users
```

Response:

```json
{
    "content": [
        {
            "id": 152,
            "name": "Alfonzo",
            "surname": "Douglas",
            "email": "Morris7@gmail.com",
            "username": "Dejon21",
            "avatarUrl": null
        }
    ],
  
}
```

### `GET /id`

Returns a specific user based on the id.

### Parameters

- id : The id of the user you want to return.

### Example

Request:

```
GET https://localhost:<yourportnumber>/users/152
```

Response:

```json
{
    "id": 152,
    "name": "Alfonzo",
    "surname": "Douglas",
    "email": "Morris7@gmail.com",
    "username": "Dejon21",
    "avatarUrl": null
}
```

### `POST`

Saves an user object in the server.

## **BODY**

- The body to send in the request.

```json
{
    "name": "Alfonzo",
    "surname": "Douglas",
    "email": "Morris7@gmail.com",
    "username": "Dejon21"
}
```

### Example

Request:

```
POST https://localhost:<yourportnumber>/users/
```

Response:

- The id of the new user created

```json
{
    "id": 152
}
```

### `PUT /id`

Update an user object in the server.

### Parameters

- id : The id of the user you want to update.

## **BODY**

- The body to send in the request.

```json
{
    "name": "Alfonzo",
    "surname": "Douglas",
    "email": "Morris7@gmail.com",
    "username": "Dejon21"
}
```

### Example

Request:

```
PUT https://localhost:<yourportnumber>/users/152
```

Response:

```json
{
    "id": 152,
    "name": "modified name",
    "surname": "modified surname",
    "email": "modified email",
    "username": "modified username",
    "avatarUrl": null
}
```

### `PATCH /id/upload`

Upload and update the user avatar url.

### Parameters

- id : The id of the user you want to update.
- image: The image file you want to upload.

### Example

Request:

```
PUT https://localhost:<yourportnumber>/users/152/upload

The body of the request has to be in form-data format.

Add the image property with value your image file.
```

Response:

- The url converted image file that will be added in the user avatarUrl proerty.

```json
http://res.cloudinary.com/dr4x8lu8f/image/upload/v1705665162/jtxt1ia92caxy5sxswur.png
```

### `DELETE /id`

Delete an user object in the server.

### Parameters

- id : The id of the user you want to delete.

### Example

Request:

```
DELETE https://localhost:<yourportnumber>/users/152
```

Response: void

```json
[]
```

## Errors

This API uses the following error codes:

- `400 Bad Request`: The request was malformed or missing required parameters.
- `404 Not Found`: The requested resource was not found.
- `500 Internal Server Error`: An unexpected error occurred on the server.
