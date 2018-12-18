// ISharedMem.aidl
package com.prasanth.cryptolist.sharedmemory;

import android.os.ParcelFileDescriptor;

interface ISharedMem {
    ParcelFileDescriptor OpenSharedMem(String name, int size, boolean create);
}