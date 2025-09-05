from fastapi import FastAPI, HTTPException
from fastapi.responses import JSONResponse
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from datetime import datetime
import json

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

print()


class User(BaseModel):
    username: str
    password: str

class LoginAttempt(BaseModel):
    username: str
    success: bool
    timestamp: str
    ip_address: str

@app.post("/authenticate")
async def authenticate_user(user: User):
    # Placeholder for user authentication logic
    if user.username == "admin" and user.password == "admin123":
        return {"authenticated": True, "email": "admin@example.com"}
    return JSONResponse(status_code=401, content={"authenticated": False})

@app.post("/log_attempt")
async def log_login_attempt(attempt: LoginAttempt):
    # Placeholder for logging login attempts
    print(f"Login attempt: {attempt.username}, Success: {attempt.success}, Timestamp: {attempt.timestamp}, IP: {attempt.ip_address}")
    return {"status": "logged"}

if __name__ == "__main__":
    import uvicorn

