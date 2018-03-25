# Json Jackson - Json Simple -Junit 4 - Junit 5 - Java 8
A json example using jackson and json object from json simple.
The json has a complex json scenario.i.e. json within json.
I have build an API endpoint to return the json via a GET, so that we have another entry point for test.

### Junit 5 and SpringBoot do not work out of the box at the current versions.
Yep, its true.

If you try this, you will find your your @Autowired dependencies return a null pointer.
This is because we lose context at runtime of our injection.
To curb this, we need to extend our SpringBootTest to include some other dependencies. 

### The Cool stuff: 
@RunWith -> JunitPlatform.class, to run test tags with
@IncludeTags
@ExcludeTags
@SuiteDisplayName
@Tag -> test tags
@RepeatableTest
@DisplayName

### Java 8 Lambda
I use java 8 lambda on assertAll for junit-jupiter.

### SpringBoot support:
Using spring to build the API is like super simple.
Using SpringBoot Dependency Injection -> @AutoWired to pull through our business/data-layer.

#### Reachout at : https://www.linkedin.com/in/suveerp/





