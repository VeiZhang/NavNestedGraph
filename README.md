## 嵌套导航示例
多NavController <-> 多navigation <-> 多NavHostFragment

#### Google官方示例

* [设计导航图](https://developer.android.google.cn/guide/navigation/navigation-design-graph)
* [嵌套导航图](https://developer.android.google.cn/guide/navigation/navigation-nested-graphs)
* [条件导航](https://developer.android.com/guide/navigation/navigation-conditional)


#### 大神示例

* [nav-nested-graph](https://github.com/dscoppelletti/nav-nested-graph)
* [NestedNavigationGraphExample](https://github.com/usman14/NestedNavigationGraphExample)


#### 疑惑解答

* [Back button doesn't work properly between top-level destinations in a nested graph](https://issuetracker.google.com/issues/140124444)
* [New navigation component from arch with nested navigation graph](https://stackoverflow.com/questions/50730494/new-navigation-component-from-arch-with-nested-navigation-graph)
* [Exit from nested Navigation Graph](https://stackoverflow.com/questions/57614986/exit-from-nested-navigation-graph)
* [Androidx - How to handle Nested Graph's fragments from parent fragment using Navigation?](https://stackoverflow.com/questions/58072616/androidx-how-to-handle-nested-graphs-fragments-from-parent-fragment-using-nav)
* [How to close a parent fragment from child fragment in navigation component](https://stackoverflow.com/questions/54037753/how-to-close-a-parent-fragment-from-child-fragment-in-navigation-component)


#### 总结

* 遵循官方示例，有且仅持有一个NavController，不能创建nav_graph视图就有多少NavController和NavHostFragment；这样back键处理有问题。
* 嵌套视图中，也是由根NavController去处理跳转和回退事件

但是，只持有一个NavController，他们的ParentFragment就是RootFragment，
如果有多个NavController，那就可以有多个ParentFragment；但是这里有问题，退出会有问题，不刷新或者是没有子Fragment的视图