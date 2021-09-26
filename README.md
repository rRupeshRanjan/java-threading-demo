# java-threading-demo
Short code snippets for java executorService, callables, runnable and streams API.

###Type of Thread Pool
1. **Single Thread Executor**: A thread pool with only one thread. So all the submitted printTasks will be executed sequentially.
   - _Method_: Executors.newSingleThreadExecutor()
3. **Cached Thread Pool**: A thread pool that creates as many threads it needs to execute the task in parallel. The old available threads will be reused for the new printTasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. 
   - _Method_: Executors.newCachedThreadPool()
4. **Fixed Thread Pool**: A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for other task to end. 
   - _Method_: Executors.newFixedThreadPool()
5. **Scheduled Thread Pool**: A thread pool made to schedule future task. 
   - _Method_: Executors.newScheduledThreadPool()
6. **Single Thread Scheduled Pool**: A thread pool with only one thread to schedule future task.
   - _Method_: Executors.newSingleThreadScheduledExecutor()

### Different ways to invoke:
1. **invokeAll()**: executorService.invokeAll(Collection<Callables>) takes collection of callables and runs them on available threadpool.
2. **execute()**: executorService.execute(Runnable) takes runnable as input and does the same. It has a return type of void.
3. **submit()**: This can be invoked on Runnable or Callable both and returns a Future object with response.

### Runnable vs Callable:
   1. Runnable: 
      - Runnable Tasks can be run with Thread class or ExecutorService. 
      - Runnable _Interface_ is a functional interface, has a single run() method which takes no input parameter, and returns no output.
      - Since the run() method signature does not have the “throws” clause specified, there is no way to propagate further checked exceptions.
   2. Callable:
      - Callable Tasks can be run only with ExecutorService.
      - The Callable interface is a generic interface containing a single call() method – which returns a generic value within a Future object.
      - The exceptions are collected in the Future object, which can be checked by making a call to the Future.get() method. This will throw an ExecutionException – which wraps the original exception
