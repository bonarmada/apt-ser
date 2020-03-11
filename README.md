# apt-ser

Code challenge for apt-ser apps. 
[APK can be downloaded here](https://drive.google.com/file/d/1D6i062QHjKMoqFz2qr05fXOerVItrCaR/view?usp=sharing)

MinSdk 23 - [as all practical, and rational developers should use](https://twitter.com/minsdkversion)

#### Persistence
Used repository pattern, simple but clear data flow from remote source to UI. Used Room and SharedPreferences to persists data.


#### Architecture
App is purely written in kotlin, Used MVVM architectural pattern


#### UI annd Design
Functional, intuitive and aestethically pleasing design. Originally planned to be minimal and neutral but later on decided to choose my own palette, followed Material Design guidelines such as emphasis on vital information.


#### Dependencies
Most of these are pretty much community standards.

* Dagger2 - [Depedency injector](https://github.com/google/dagger) for android.
* Retrofit2 & OkHttp - Networking and http client
* Gson - Mapper tool for json objects.
* Room & ViewModel - used for persistence, also used ViewModels to mannage UI-related data i.e persisted data, view objects. 
* RxJava & LiveData - reactive UI, works seemlessly with data emmited by data sources.. Also for thread management.

