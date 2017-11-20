package tegprogramming.com.widget_example;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by TroysMacBook on 11/19/17.
 */


    public class WidgetService extends RemoteViewsService {

        @Override
        public RemoteViewsFactory onGetViewFactory(Intent intent) {

            WidgetDataProvider dataProvider = new WidgetDataProvider(
                    getApplicationContext(), intent);
            return dataProvider;
        }

    }






