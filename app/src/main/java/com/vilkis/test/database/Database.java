package com.vilkis.test.database;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class Database implements RealmMigration {

    private Realm realm;

    public Database() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(0)
                .migration(new Database())
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }

    public void executeTransaction(Realm.Transaction transaction) {
        realm.executeTransaction(transaction);
    }

    public void close() {
        realm.close();
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
