## spring-boot
#####Spring Boot Project to 

	-Test In Memory DB Connectivity

	-Rest controller test by Spring Test and JUnit5

Propagation

	+-------+---------------------------+-----------------------------------------------------------------------------------------------------------+
	| value | Propagation 		    | Description										            	|
	+-------+---------------------------+-----------------------------------------------------------------------------------------------------------+
	| -1 	| TIMEOUT_DEFAULT 	    | Use the default timeout of the underlying transaction system, or none if timeouts are not supported.	|
	| 0 	| PROPAGATION_REQUIRED 	    | Support a current transaction; create a new one if none exists. 						|
	| 1 	| PROPAGATION_SUPPORTS 	    | Support a current transaction; execute non-transactionally if none exists. 				|
	| 2 	| PROPAGATION_MANDATORY	    | Support a current transaction; throw an exception if no current transaction exists. 			|
	| 3 	| PROPAGATION_REQUIRES_NEW  | Create a new transaction, suspending the current transaction if one exists. 			        |
	| 4 	| PROPAGATION_NOT_SUPPORTED | Do not support a current transaction; rather always execute non-transactionally. 				|
	| 5 	| PROPAGATION_NEVER 	    | Do not support a current transaction; throw an exception if a current transaction exists. 		|
	| 6 	| PROPAGATION_NESTED 	    | Execute within a nested transaction if a current transaction exists. 					|
	+-------+---------------------------+-----------------------------------------------------------------------------------------------------------+

Isolation

	+---------------------------+-------------------+-------------+-------------+------------------------+
	| Isolation Level Mode      |  Read             |   Insert    |   Update    |       Lock Scope       |
	+---------------------------+-------------------+-------------+-------------+------------------------+
	| READ_UNCOMMITTED          |  uncommitted data | Allowed     | Allowed     | No Lock                |
	| READ_COMMITTED (Default)  |   committed data  | Allowed     | Allowed     | Lock on Committed data |
	| REPEATABLE_READ           |   committed data  | Allowed     | Not Allowed | Lock on block of table |
	| SERIALIZABLE              |   committed data  | Not Allowed | Not Allowed | Lock on full table     |
	+---------------------------+-------------------+-------------+-------------+------------------------+


REST API:
	
    Accept and respond with JSON. 
    Use nouns instead of verbs in endpoint paths. 
    Name collections with plural nouns. 
    Nesting resources for hierarchical objects. 
    Handle errors gracefully and return standard error codes. 
    Allow filtering, sorting, and pagination.
    Maintain Good Security Practices.
    Cache data to improve performance.

### JUnit
https://spring.io/guides/gs/testing-web/   

# ***Don't forget to add equal and hashcode method*** 

#### Spring JUnit 
    //JUnit 4
    @RunWith(SpringJUnit4ClassRunner.class)
    
    //JUnit 5
    @ExtendWith(SpringExtension.class)  // not required in case of junit5
#### Spring Test Framework
    //1. Web Layer Test 
    @WebMvcTest //Can narrow the tests to only the web layer by using @WebMvcTest. Spring Boot instantiates only the web layer rather than the whole context
    
    //or 2. Web Layer Test
    @WebMvcTest (RESTController.class) // Load only one controller
    
    //OR 3. Web Layer Test
    @SpringBootTest
    @AutoConfigureMockMvc    