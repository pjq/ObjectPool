Object Pool Design Pattern
==========

Object Pool design pattern demo

Reference
- [Object pool](http://sourcemaking.com/design_patterns/object_pool)
- [Wikipedia Object pool pattern](https://en.wikipedia.org/wiki/Object_pool_pattern)

Demo
=========
[Source code(Java)](https://github.com/pjq/ObjectPool/tree/master/app/src/main/java/me/pjq/objectpool/app/demo)


Definition
=========
The object pool pattern is a creational design pattern that uses a set of initialized objects kept ready to use – a "pool" – rather than allocating and destroying them on demand. A client of the pool will request an object from the pool and perform operations on the returned object. When the client has finished, it returns the object to the pool rather than destroying it; this can be done manually or automatically.

Intent
=========

Object pooling can offer a significant performance boost; it is most effective in situations where the cost of initializing a class instance is high, the rate of instantiation of a class is high, and the number of instantiations in use at any one time is low.

Problem
=========

Object pools (otherwise known as resource pools) are used to manage the object caching. A client with access to a Object pool can avoid creating a new Objects by simply asking the pool for one that has already been instantiated instead. Generally the pool will be a growing pool, i.e. the pool itself will create new objects if the pool is empty, or we can have a pool, which restricts the number of objects created.

It is desirable to keep all Reusable objects that are not currently in use in the same object pool so that they can be managed by one coherent policy. To achieve this, the Reusable Pool class is designed to be a singleton class.


Structure
=========
![Object pool example](http://sourcemaking.com/files/v2/content/patterns/Object_pool_example1-2x.png)

Discussion
=========

The Object Pool lets others "check out" objects from its pool, when those objects are no longer needed by their processes, they are returned to the pool in order to be reused.

However, we don't want a process to have to wait for a particular object to be released, so the Object Pool also instantiates new objects as they are required, but must also implement a facility to clean up unused objects periodically.

Check list
=========

- Create ObjectPool class with private array of Objects inside
- Create acquare and release methods in ObjectPool class
- Make sure that your ObjectPool is Singleton

Examples
=========
In the .NET Base Class Library there are a few objects that implement this pattern. System.Threading.ThreadPool is configured to have a predefined number of threads to allocate. When the threads are returned, they are available for another computation. Thus, one can use threads without paying the cost of creation and disposal of threads.

Java supports thread pooling via <b>java.util.concurrent.ExecutorService</b> and other related classes. The executor service has a certain number of "basic" threads that are never discarded. If all threads are busy, the service allocates the allowed number of extra threads that are later discarded if not used for the certain expiration time. If no more threads are allowed, the tasks can be placed in the queue. Finally, if this queue may get too long, it can be configured to suspend the requesting thread.