package com.example.sdfnash.myapplication.ui.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sdfnash.myapplication.R;
import com.example.sdfnash.myapplication.adapter.TestAdapter;
import com.example.sdfnash.myapplication.manager.DataManager;
import com.example.sdfnash.myapplication.model.TestModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView listView;
    TestAdapter mAdapter;
    TestTask testTask = new TestTask();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView) findViewById(R.id.list);
        mAdapter = new TestAdapter(DataManager.getInstance().initData(),this);
        mAdapter.addHeader(new View(MainActivity.this));
        mAdapter.addBottom(new View(MainActivity.this));
        listView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listView.setAdapter(mAdapter);

        Snackbar.make(listView, "hrllo", 50000).setAction("click", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        }).show();

        testTask.execute(new TestModel());
        handler.post(new TestRunnable() {
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                super.run();
                handler.sendEmptyMessage(4);
            }
        });

    }





    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }



    class TestRunnable implements Runnable {
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }
    }

    class MyHandler extends Handler {
        /**
         * Subclasses must implement this to receive messages.
         *
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }

        /**
         * Handle system messages here.
         *
         * @param msg
         */
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
        }

        /**
         * Returns a string representing the name of the specified message.
         * The default implementation will either return the class name of the
         * message callback if any, or the hexadecimal representation of the
         * message "what" field.
         *
         * @param message The message whose name is being queried
         */
        @Override
        public String getMessageName(Message message) {
            return super.getMessageName(message);
        }

        /**
         * Enqueue a message into the message queue after all pending messages
         * before the absolute time (in milliseconds) <var>uptimeMillis</var>.
         * <b>The time-base is {@link SystemClock#uptimeMillis}.</b>
         * Time spent in deep sleep will add an additional delay to execution.
         * You will receive it in {@link #handleMessage}, in the thread attached
         * to this handler.
         *
         * @param msg
         * @param uptimeMillis The absolute time at which the message should be
         *                     delivered, using the
         *                     {@link SystemClock#uptimeMillis} time-base.
         * @return Returns true if the message was successfully placed in to the
         * message queue.  Returns false on failure, usually because the
         * looper processing the message queue is exiting.  Note that a
         * result of true does not mean the message will be processed -- if
         * the looper is quit before the delivery time of the message
         * occurs then the message will be dropped.
         */
        @Override
        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            return super.sendMessageAtTime(msg, uptimeMillis);
        }
    }

    public class TestTask extends AsyncTask<TestModel, Integer, String> {
        /**
         * Creates a new asynchronous task. This constructor must be invoked on the UI thread.
         */
        public TestTask() {
            super();
        }

        /**
         * Runs on the UI thread before {@link #doInBackground}.
         *
         * @see #onPostExecute
         * @see #doInBackground
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         * <p>
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param s The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        /**
         * Runs on the UI thread after {@link #publishProgress} is invoked.
         * The specified values are the values passed to {@link #publishProgress}.
         *
         * @param values The values indicating progress.
         * @see #publishProgress
         * @see #doInBackground
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         * <p>Runs on the UI thread after {@link #cancel(boolean)} is invoked and
         * {@link #doInBackground(Object[])} has finished.</p>
         * <p>
         * <p>The default implementation simply invokes {@link #onCancelled()} and
         * ignores the result. If you write your own implementation, do not call
         * <code>super.onCancelled(result)</code>.</p>
         *
         * @param s The result, if any, computed in
         *          {@link #doInBackground(Object[])}, can be null
         * @see #cancel(boolean)
         * @see #isCancelled()
         */
        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        /**
         * <p>Applications should preferably override {@link #onCancelled(Object)}.
         * This method is invoked by the default implementation of
         * {@link #onCancelled(Object)}.</p>
         * <p>
         * <p>Runs on the UI thread after {@link #cancel(boolean)} is invoked and
         * {@link #doInBackground(Object[])} has finished.</p>
         *
         * @see #onCancelled(Object)
         * @see #cancel(boolean)
         * @see #isCancelled()
         */
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(TestModel... params) {
            return null;
        }
    }
}
