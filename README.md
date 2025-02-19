# 🎬 Video Streaming Application

## 📜 1. Problem Statement

### Overview
Our client, a major Hollywood production house, is gearing up to create a next-generation video streaming platform. To make this vision a reality, they have tasked us with developing the tooling for their content managers. The core purpose is to allow them to manage and publish video content, track viewership metrics, and enable monetization.

### Functional Requirements

#### Core Functionalities:
- **Store Information:** Manage and store metadata related to videos.
- **Stream Video Content:** Enable video streaming for users.
- **Track User Engagement:** Collect and monitor video engagement metrics such as views and impressions.

#### User Stories:
- **Publish a Video:** Content managers should be able to publish videos.
- **Manage Metadata:** Add, edit, and manage metadata associated with videos (e.g., title, synopsis, director, cast, genre, year of release, running time).
- **Delist a Video:** Soft delete a video and its associated metadata when necessary.
- **Load Video:** Fetch and return the metadata and content of a specific video.
- **Play Video:** Allow users to play a video by returning content related to the video (mock video content in this case).
- **List All Videos:** List available videos with a subset of metadata (e.g., title, director, main actor, genre, running time).
- **Search for Videos:** Search for videos based on criteria (e.g., movies by a specific director). Return only essential metadata in the results.
- **Engagement Stats:** Retrieve video engagement statistics, including:
    - **Impressions:** A client loading a video.
    - **Views:** A client playing a video.

## 🛠️ 2. Pre-requisites
Before running the application, ensure you have the following installed:

- **Java** (version 17 or higher)
- **Maven** (for build lifecycle management)
- **IDE** (e.g., IntelliJ IDEA, Eclipse, VS Code)

## 🚀 3. Commands to Execute

To set up and run the application, follow these steps:

1. **Clean and Build the Application:**
```bash
mvn clean install
```
2. **Run the Spring Boot Application::**
```bash
mvn spring-boot:run
```
