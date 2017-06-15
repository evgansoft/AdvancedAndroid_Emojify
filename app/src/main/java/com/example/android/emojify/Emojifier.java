package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(final Context context, final Bitmap bitmap) {
        final FaceDetector detector = new FaceDetector.Builder(context)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();
        final Frame frame = new Frame.Builder()
                .setBitmap(bitmap)
                .build();
        final SparseArray<Face> faces = detector.detect(frame);
        Log.i(TAG, String.format("Found %d face(s)", faces.size()));
        if (faces.size() == 0) {
            Toast.makeText(context, "No faces detected", Toast.LENGTH_SHORT).show();
        }
        detector.release();
    }
}
