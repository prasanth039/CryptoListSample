package com.prasanth.cryptolist.sharedmemory.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.prasanth.cryptolist.sharedmemory.ISharedMem;

import java.io.IOException;

public class ShmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ISharedMem.Stub() {
            @Override
            public ParcelFileDescriptor OpenSharedMem(String name, int size, boolean create)
                    throws RemoteException {
                int fd = ShmLib.OpenSharedMem(name, size, create);
                try {
                    return ParcelFileDescriptor.fromFd(fd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }
}