package tegprogramming.com.widget_example;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by TroysMacBook on 11/18/17.
 */

public class Widget_Main_Activity extends AppWidgetProvider {




    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        for (int widgetId : appWidgetIds) {
            RemoteViews mView = initViews(context, appWidgetManager, widgetId);
            appWidgetManager.updateAppWidget(widgetId, mView);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private RemoteViews initViews(Context context,
                                  AppWidgetManager widgetManager, int widgetId) {

        RemoteViews mView = new RemoteViews(context.getPackageName(),
                R.layout.widget_main_activity);

        Intent intent = new Intent(context, WidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
        mView.setRemoteAdapter(widgetId, R.id.widgetCollectionList, intent);

        return mView;
    }



}







