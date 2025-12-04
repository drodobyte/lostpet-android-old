# Lost Pet on Android
Simple sample app for posting lost pets showcasing [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) approach.

The _business_ layer is defined in the [domain](https://github.com/drodobyte/lostpet-android/tree/master/domain) module, 
the _details_ and _adapter_ layers are defined in the [details](https://github.com/drodobyte/lostpet-android/tree/master/details) one.

### Packages
* **Domain**
  * **Case**, it contains the use cases (e.g: _listing pets_)
  * **Entity**, the models (e.g: _Pet_)
  * **Service**, the access data service
* **Details**
  * **Presentation**, It contains Android specifics implementing views and user interaction, and also the presenters, which are adapters to the use-cases from business model layer and the android specific framework.
  * **Service**, doubles or mocked service classes implementing the service interface defined in the business model layer.
  * **util & app**, utility and helper classes
