package com.vilkis.test.database;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {

    public Migration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(0)
                .migration(new Migration())
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        Realm.getDefaultInstance();
    }

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            schema.create("Character")
                    .addField("id", int.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name", String.class)
                    .addField("birthday", String.class)
                    .addRealmListField("occupation", String.class)
                    .addField("image", String.class)
                    .addField("status", String.class)
                    .addField("nickname", String.class)
                    .addField("portrayed", String.class);
        }
    }
}
