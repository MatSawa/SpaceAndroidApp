# SpaceApp

What can be improved:
* [PagedListAdapter](https://developer.android.com/reference/androidx/paging/PagedListAdapter) - PagedListAdapter in LaunchesFragment
* [Room with LiveData](https://developer.android.com/topic/libraries/architecture/livedata#use_livedata_with_room) - LaunchesRepository: ``
fun getLaunches(): LiveData<List<Launch>>
`` instead of: ``
fun getLaunches(): Single<List<Launch>>
``

License
----

NULL ;)