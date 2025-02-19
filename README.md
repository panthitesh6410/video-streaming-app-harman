<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Video Streaming Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 20px;
            padding: 0;
            color: #333;
            background-color: #f9f9f9;
        }
        h1, h2 {
            color: #1a73e8;
        }
        h3 {
            color: #4CAF50;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            overflow-x: auto;
        }
        ul {
            list-style-type: square;
            margin-left: 20px;
        }
        ol {
            margin-left: 20px;
        }
        .highlight {
            color: #d32f2f;
        }
        .note {
            background-color: #fff3e0;
            border-left: 5px solid #ff9800;
            padding: 10px;
            margin: 20px 0;
        }
    </style>
</head>
<body>

    <h1>🎬 <strong>Video Streaming Application</strong></h1>

    <h2>📜 1. Problem Statement</h2>

    <h3>Overview</h3>
    <p>Our client, a major Hollywood production house, is gearing up to create a next-generation video streaming platform. To make this vision a reality, they have tasked us with developing the tooling for their content managers. The core purpose is to allow them to manage and publish video content, track viewership metrics, and enable monetization.</p>

    <h3>Functional Requirements</h3>
    <p>The application will focus on the following key features:</p>

    <h4>Core Functionalities:</h4>
    <ul>
        <li><strong>Store Information:</strong> Manage and store metadata related to videos.</li>
        <li><strong>Stream Video Content:</strong> Enable video streaming for users.</li>
        <li><strong>Track User Engagement:</strong> Collect and monitor video engagement metrics such as views and impressions.</li>
    </ul>

    <h4>User Stories:</h4>
    <ul>
        <li><strong>Publish a Video:</strong> Content managers should be able to publish videos.</li>
        <li><strong>Manage Metadata:</strong> Add, edit, and manage metadata associated with videos (e.g., title, synopsis, director, cast, genre, year of release, running time).</li>
        <li><strong>Delist a Video:</strong> Soft delete a video and its associated metadata when necessary.</li>
        <li><strong>Load Video:</strong> Fetch and return the metadata and content of a specific video.</li>
        <li><strong>Play Video:</strong> Allow users to play a video by returning content related to the video (mock video content in this case).</li>
        <li><strong>List All Videos:</strong> List available videos with a subset of metadata (e.g., title, director, main actor, genre, running time).</li>
        <li><strong>Search for Videos:</strong> Search for videos based on criteria (e.g., movies by a specific director). Return only essential metadata in the results.</li>
        <li><strong>Engagement Stats:</strong> Retrieve video engagement statistics, including:
            <ul>
                <li><strong>Impressions:</strong> A client loading a video.</li>
                <li><strong>Views:</strong> A client playing a video.</li>
            </ul>
        </li>
    </ul>

    <h3>Technical Requirements</h3>
    <p>To implement the solution, the following technical requirements must be met:</p>
    <ul>
        <li><strong>JDK 17 or higher</strong> (Open source and LTS versions preferred).</li>
        <li><strong>Spring Boot 2.7 or higher</strong> for framework usage.</li>
        <li><strong>Maven or Gradle</strong> for dependency management and build lifecycle.</li>
        <li>Implement <strong>unit and integration tests</strong> to ensure the reliability of the application.</li>
        <li>Use a <strong>database</strong> or data store of your choice for persistent storage.</li>
        <li>Provide <strong>detailed documentation</strong> explaining design decisions, assumptions made, and instructions on how to build and run the solution.</li>
    </ul>

    <h3>Submission:</h3>
    <p>Submit the completed solution to a <strong>public repository</strong> (e.g., GitHub, GitLab, Bitbucket). The task should be completed <strong>within 6 hours</strong>.</p>

    <h2>🛠️ 2. Pre-requisites</h2>

    <p>Before running the application, ensure you have the following installed:</p>
    <ul>
        <li><strong>Java</strong> (version 17 or higher)</li>
        <li><strong>Maven</strong> (for build lifecycle management)</li>
        <li><strong>IDE</strong> (e.g., IntelliJ IDEA, Eclipse, VS Code)</li>
    </ul>

    <h2>🚀 3. Commands to Execute</h2>

    <p>To set up and run the application, follow these steps:</p>

    <h4>1. Clean and Build the Application:</h4>
    <pre><code>mvn clean install</code></pre>

    <h4>2. Run the Spring Boot Application:</h4>
    <pre><code>mvn spring-boot:run</code></pre>

    <h2>⚙️ 4. API Endpoints (Optional)</h2>

    <p>If you want to enhance the README further, you can also document your API endpoints here:</p>
    <ul>
        <li><strong>POST /videos</strong> – Publish a new video.</li>
        <li><strong>GET /videos/{id}</strong> – Load video metadata and content.</li>
        <li><strong>PUT /videos/{id}</strong> – Edit video metadata.</li>
        <li><strong>DELETE /videos/{id}</strong> – Soft delete a video.</li>
        <li><strong>GET /videos</strong> – List all available videos.</li>
        <li><strong>GET /videos/search</strong> – Search videos based on query criteria.</li>
        <li><strong>GET /videos/{id}/engagement</strong> – Retrieve engagement statistics.</li>
    </ul>

    <h2>📚 5. Documentation and Assumptions</h2>

    <p>All decisions regarding design, assumptions, and chosen technologies are explained in the documentation inside the repository. Make sure to review it for a better understanding of the project architecture.</p>

</body>
</html>
