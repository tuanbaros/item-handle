# item-handle
Android library make simple handling action for item of Android RecyclerView

Require
-----

* API 14 or higher

Usage
-----

### Dependency

Add to ``root/build.gradle``

```groovy
repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
  }
```

Include the library in your ``app/build.gradle``

```groovy
dependencies{
    compile 'com.github.tuanbaros:item-handle:v0.1'
}
```

### Step by step

1. Define ``SimpleRecyclerView`` in your layout

```xml
	    <com.simple.handling.SimpleRecyclerView
              android:id="@+id/simple_recycler_view"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"/>
```

2. Define your adapter extend ``SimpleAdapter`` and view holder extend ``SimpleViewHolder`` like below

```java
public class SampleAdapter extends SimpleAdapter {

      private List<String> mList;

      public SampleAdapter(List<String> list) {
          mList = list;
      }

      @Override
      public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
          return new ViewHolder(view);
      }

      @Override
      public void onBindViewHolder(SimpleViewHolder holder, int position) {
          super.onBindViewHolder(holder, position);
          TextView textView = holder.itemView.findViewById(R.id.text_view);
          textView.setText(mList.get(position));
      }

      @Override
      public int getItemCount() {
          return mList == null ? 0 : mList.size();
      }

      private class ViewHolder extends SimpleViewHolder {
          ViewHolder(View itemView) {
              super(itemView);
          }
      }
  }
```

3. Set adapter and item handle
```java
	SimpleRecyclerView simpleRecyclerView =
                  (SimpleRecyclerView) findViewById(R.id.simple_recycler_view);
          simpleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
          simpleRecyclerView.setHasFixedSize(true);
          simpleRecyclerView.setAdapter(new SampleAdapter(list));
          simpleRecyclerView.setOnItemAction(new ItemAction() {
              @Override
              public void onTap(View view, int position) {
                  Log.i("tap", position + "");
              }

              @Override
              public void onLongTap(View view, int position) {
                  Log.i("long", position + "");
              }

              @Override
              public void onDoubleTap(View view, int position) {
                  Log.i("double", position + "");
              }
          });
```

### Note
  You only need ``override`` method you want in ``onTap, onLongTap, onDoubleTap``. Happy coding!

