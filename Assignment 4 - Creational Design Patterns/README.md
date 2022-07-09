# Lab 4

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

Once you have familiarized yourself with the scenario provided above, you must review the code from the previous iteration (solution to lab1 provided) and proceed with code refactoring by applying Design Patterns in order to improve the general design.

## Tasks

### Refactoring

1. Since the Class Log itself has an attachment of the Class File, all its Subclasses (TextLog, AudioLog, VideoLog and ImageLog) have their corresponding one. The problem is that the Subclasses of both are tightly coupled, so the correspondence of types must be validated.

- Decouple the classes by generalizing the Class Log as a one and single concrete Class, and delegate the type validation to the File Class and Subclasses.

### Simple Builder Pattern

1. Implement a Builder for the class Log to reduce complexity and gain flexibility on passing parameters on creation.

2. Change the Main class accordingly.

### Singleton Pattern

1. The Class Log includes a Method for generating the shortcode on creation. The problem is that even though they are randomly generated, because the maximum number of possible combinations are on high demand, the shortcodes may be duplicated. Delegate that task to a new Class named ShortCodeGenerator in order to ensure the codes are unique.

2. Make sure the new generator is thread safe.

### Factory Method

1. When creating the Files to be used as attachments, in the way it is right now, the Main class must determine which type of object has to be created in compile-time. This reduces flexibility because in a real case scenario, a stream of submissions would come. Therefore, the controller receiving the submissions (Servlet) would not know what type to choose. Implement a Factory for the media Files used for the attachments so its creation can be freely done in run-time.

2. Change the Main class accordingly.

Remember that although the scenario and resulting model may be used for future activities, the main goal is to practice what you have learned in this module, so do not be worried about finding the perfect solution for this case. And keep in mind that System.out.println() will be enough for the purposes of illustrating your model.
