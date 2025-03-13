# Blog Backend API

A **Spring Boot** backend API for creating, updating, and deleting blog posts with **authentication and authorization** 🚀 Features

- User authentication (JWT-based)
- CRUD operations for blog posts
- Role-based access control (Users & Admins)
- Spring Security for authentication
- Database integration (MySQL)

🛠️ Technologies Used

- **Spring Boot** (Backend Framework)
- **Spring Security & JWT** (Authentication)
- **Spring Data JPA** (Database Handling)
- **MySQL** (Database)
- **Lombok** (Simplifies Java Code)

📌 API Endpoints

🔐 Authentication

| Method | Endpoint             | Description       |
| ------ | -------------------- | ----------------- |
| POST   | `/security/register` | User registration |
| POST   | `/security/login`    | User login (JWT)  |

### 📝 Blog Posts

| Method | Endpoint           | Description                       |
| ------ | ------------------ | --------------------------------- |
| GET    | `/api`/fetch       | Get all blogs                     |
| GET    | `/api/fetch/{id}`  | Get a single blog by ID           |
| POST   | `/api/`add         | Create a new blog (Authenticated) |
| PUT    | `/api/`update      | Update a blog (Author only)       |
| DELETE | `/api/delete/{id}` | Delete a blog (Author/Admin)      |

⚡ Installation & Setup

 1️⃣ Clone the Repository

```sh
git clone https://github.com/your-username/blog-backend.git
cd blog-backend
```

 2️⃣ Configure Database

- Update `application.properties` or `application.yml` with your database credentials.

 3️⃣ Run the Application

```sh
mvn spring-boot:run
```

 4️⃣ Access the API

- API is available at `http://localhost:8080`
- Use **Postman** or **cURL** to test endpoints

 🔐 Authentication & Authorization

- Register a new user via `/api/auth/register`
- Get a JWT token by logging in `/api/auth/login`
- Include the **JWT token** in `Authorization: Bearer <token>` for protected routes

 📜 License

This project is licensed under the MIT License.

 📞 Contact

For issues, open a GitHub issue or reach out at [satha6374@gmail.com](mailto\:satha6374@gmail.com)

