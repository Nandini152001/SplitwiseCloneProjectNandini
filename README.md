# SplitwiseCloneProjectNandini
Here, from today 9th June 2026 onwards I will be doing daily progress on my project and will add amazing functionalities one step closer every time to learn and build meaningful project.

Bilkul bro. GroupMembers start karne se pehle ek **day-wise roadmap / progress log** banana best idea hai. Ye later GitHub README, interview explanation, aur self-confidence ke liye kaam aayega.

## Splitwise Clone — Progress Roadmap Till Now

### Day 1 — Project Setup + Basic REST Flow

**Goal:** Spring Boot project ko run karna and basic API flow samajhna.

Done:

```text
Spring Boot project setup
Package structure created
Health endpoint tested
UserController created
UserService created
Basic in-memory List<User> based CRUD started
Swagger UI setup
```

Concepts learned:

```text
@RestController
@GetMapping
@PostMapping
@RequestBody
@PathVariable
Controller → Service flow
```

---

### Day 2 — User CRUD with In-Memory List

**Goal:** Database ke bina CRUD logic samajhna.

Done:

```text
createUser()
getAllUsers()
getUserById()
updateUser()
deleteUserById()
```

Initially data yahan store ho raha tha:

```java
private List<User> users = new ArrayList<>();
```

Concepts learned:

```text
Service layer responsibility
Optional
Streams
filter()
orElseThrow()
Custom exception basics
```

---

### Day 3 — PostgreSQL + JPA + Repository

**Goal:** In-memory list se actual database persistence par shift karna.

Done:

```text
PostgreSQL installed
splitwise_clone database created
application.properties configured
User entity created with @Entity
UserRepository created using JpaRepository
UserService migrated from List<User> to UserRepository
Data saved successfully in PostgreSQL
```

Concepts learned:

```text
@Entity
@Table
@Id
@GeneratedValue(strategy = IDENTITY)
JpaRepository
Hibernate
JDBC driver
Repository layer
Constructor injection
final field initialization
```

Big milestone:

```text
Swagger POST /users
↓
Controller
↓
Service
↓
Repository
↓
Hibernate
↓
PostgreSQL
```

---

### Day 4 — User Module Production Style

**Goal:** User API ko cleaner and production-style banana.

Done:

```text
REST endpoints cleaned
/createuser → POST /users
/getusers → GET /users
/user/{id} → GET /users/{id}
PUT /users/{id}
DELETE /users/{id}
```

Then DTOs added:

```text
UserRequestDTO
UserResponseDTO
```

Validation added:

```text
@NotBlank
@Email
@Valid
```

Global exception handling improved:

```text
UserNotFoundException
MethodArgumentNotValidException handling
Clean validation error response
```

HTTP status polish:

```text
POST /users → 201 Created
GET /users → 200 OK
GET /users/{id} → 200 OK / 404 Not Found
DELETE /users/{id} → 200 OK with message
Validation fail → 400 Bad Request
```

Concepts learned:

```text
DTO vs Entity
RequestDTO vs ResponseDTO
ResponseEntity
HTTP status codes
GlobalExceptionHandler
Validation flow
Map<String, String> for field-wise errors
```

---

### Day 5 — ExpenseGroup Module

**Goal:** Splitwise ka Group feature start karna.

Done:

```text
ExpenseGroup entity created
ExpenseGroupRepository created
expense_groups table created in PostgreSQL
ExpenseGroupRequestDTO created
ExpenseGroupResponseDTO created
ExpenseGroupNotFoundException created
GlobalExceptionHandler updated
ExpenseGroupService created
ExpenseGroupController created
```

APIs completed:

```text
POST /groups
GET /groups
GET /groups/{id}
PUT /groups/{id}
DELETE /groups/{id}
```

Validation and error handling:

```text
Group name validation
404 for group not found
Clean REST endpoints
DTO response mapping
```

Concepts learned:

```text
Table naming
Entity id vs groupId in DTO
@PathVariable vs @RequestParam
findById + delete vs deleteById
ResponseDTO mapping
Service helper methods
CRUD repetition and why it exists
```

---

## Current Project Status

```text
User Module ✅ Complete
ExpenseGroup Module ✅ Complete
PostgreSQL Integration ✅ Done
DTO Pattern ✅ Done
Validation ✅ Done
Global Exception Handling ✅ Done
REST Endpoints ✅ Done
Swagger Testing ✅ Done
```

Current architecture:

```text
Controller
↓
RequestDTO
↓
Service
↓
Entity
↓
Repository
↓
PostgreSQL
↓
ResponseDTO
↓
Client
```

---

## Next Roadmap

### Day 6 — GroupMember Module

Goal:

```text
Connect Users with ExpenseGroups
```

We will create:

```text
GroupRole enum
GroupMember entity
GroupMemberRepository
AddGroupMemberRequestDTO
GroupMemberResponseDTO
GroupMemberService
GroupMemberController
```

First API:

```text
POST /groups/{groupId}/members
```

Request:

```json
{
  "userId": 2
}
```

Response:

```json
{
  "memberId": 1,
  "groupId": 5,
  "userId": 2,
  "userName": "Nandini",
  "role": "MEMBER"
}
```

Concepts we’ll learn:

```text
@ManyToOne
@JoinColumn
Enum mapping
Relationship tables
Duplicate member validation
Business rule checks
```

---

### Day 7 — List and Remove Group Members

APIs:

```text
GET /groups/{groupId}/members
DELETE /groups/{groupId}/members/{userId}
```

Concepts:

```text
Query methods in repository
findByExpenseGroupId
findByUserId
existsBy...
Custom validation
```

---

### Day 8 — Expense Module Start

Entities:

```text
Expense
ExpenseSplit
```

Concepts:

```text
Who paid?
Who owes?
Amount
Split type
Equal split
```

---

### Day 9 — Balance Calculation

Core Splitwise logic:

```text
User A paid ₹1000
User B owes ₹500
User C owes ₹500
```

Concepts:

```text
Balance sheet
Net payable
Net receivable
Settlement calculation
```

---

### Day 10+ — Advanced Production Features

Later:

```text
Spring Security + JWT
RequestId logging
ThreadLocal / MDC
Transactions
Pagination
Testing
Git PR workflow
Deployment
```

---

