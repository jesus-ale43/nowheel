plugins {
    id("multiloader-platform")
    id("net.fabricmc.fabric-loom")
}

loom {
    runs.named("client") {
        client()

        displayName = "fabric - Client"
        runDirectory = file("../run")
        appendProjectPathToDisplayName = false
        generateRunConfig = true
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${BuildConfig.MINECRAFT_VERSION}")
    implementation("net.fabricmc:fabric-loader:${BuildConfig.FABRIC_LOADER_VERSION}")

    api("net.uku3lig:ukulib-fabric:${BuildConfig.UKULIB_VERSION}")
    implementation("net.fabricmc.fabric-api:fabric-key-mapping-api-v1:2.0.8+3434d6d902")
    implementation("net.fabricmc.fabric-api:fabric-lifecycle-events-v1:4.1.6+3434d6d97a")
}

modrinth {
    loaders.add("quilt")
}