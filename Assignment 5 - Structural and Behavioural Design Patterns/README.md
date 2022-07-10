# Lab 5

## Scenario

Code&Code is a small company dedicated to Software Development. Their engineering team, to which you belong, is working on writing a Web Application as an MVP for a new customer.

The code name for this App is “Loggy”, which is meant to offer functionality for a personal journal where users can log their daily activities through text, voice and video.

The first step will be to write the main functionality, which is essentially a Microblogging System where all the posts are automatically annotated with voice, video or text.

As an initial step, you must create the skeleton of the model for the core Microblogging System under these assumptions:

- Activity logs recorded only by one user.

- Each log is dated with a timestamp that is used as the key for displaying it in the feed

- Each log should have a name, a description and a date.

- Each log has attached the actual content, which can be plain text, an image, an audio file or a video file

- The audio and video files are supported in multiple formats as they are recorded in through the browser and uploaded to the server using WebRTC API.

- The images are also supported in multiple formats.

Once you have familiarized yourself with the scenario provided above, you must review the code from the previous iteration (solution to Lab 2 provided) and proceed with code refactoring by applying Design Patterns in order to improve the general design.

The two pieces missing are:

- An interface for accessing the external service API. And finally, you connected the Workers to the API through a Proxy and/or Adapter.
 
- A Notifier acting on a callback that triggers an event when the closed-captioning process is completed, and the recording is updated.


## Tasks

### Proxy Pattern
The current code includes two classes that represent the APIs for Google and AWS services, but only a subset of the methods implemented are required for application. Because we want to expose the application only, the methods that are really required are as follows:

1. Implement a Proxy named GoogleSpeech2TextProxy for the Google API

2. Implement a Proxy named AWSTranscribeProxy for the AWS API.

3. Update the CCWorker class accordingly.
 
### Adapter Pattern

We want to make use of the same interface (therefore, the same method) for accessing the two Proxies.

1. Implement a CCGoogleAdapter and CCAWSAdapter that have the same method (although different logic) for triggering the closed-captioning process.

2. Update the CCWorker class accordingly (keep the cc triggering using local methods).

### Observer Pattern

We want to have notifications that can be sent to the Console to simulate an external Event Logging System that may be used for Analytics and Live Monitoring.

1. Implement Observer pattern being the Recording class, the Observable Subject, and a new Notifier class, the Observer.

2. The event should be triggered when the Recording is updated with the transcript (or result from the closed captioning process) and the message generated should include information from the recording itself.

3. Update the Main class accordingly.

Remember that although the scenario and resulting model may be used for future activities, the main goal is to practice what you have learned in this module, so do not be worried about finding the perfect solution for this case. And keep in mind that System.out.println() will be enough for the purposes of illustrating your model.
