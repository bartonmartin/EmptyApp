package cz.bartonmartin.empty;

import android.app.Application;
import android.content.Context;


public class EmptyApplication extends Application
{
	private static EmptyApplication mInstance;


	public static Context getContext()
	{
		return mInstance;
	}


	public EmptyApplication()
	{
		mInstance = this;
	}


	@Override
	public void onCreate()
	{
		super.onCreate();

		// force AsyncTask to be initialized in the main thread due to the bug:
		// http://stackoverflow.com/questions/4280330/onpostexecute-not-being-called-in-asynctask-handler-runtime-exception
		try
		{
			Class.forName("android.os.AsyncTask");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
