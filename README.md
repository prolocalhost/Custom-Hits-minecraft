# ⚔️ localhost-customhity

A lightweight, high-performance Minecraft Paper/Spigot plugin that allows server administrators to dynamically customize and scale player attack damage multipliers in real time.

---

## ✨ Features

- **⚡ Dynamic Damage Scaling**: Adjust damage dealt by players globally across your server using an intuitive multiplier system.
- **🔄 Live In-Game Configuration**: Modify the damage multiplier on the fly with `/customhity set <multiplier>` — changes persist directly to `config.yml` without needing a server restart.
- **📜 Config Reload Support**: Instant `/customhity reload` to apply manual config edits seamlessly.
- **⌨️ Smart Tab Completion**: Interactive tab completion for commands and suggested multiplier values.
- **🎨 Configurable Messages**: Customize every chat message with standard Minecraft color codes (`&`).
- **🚀 Lightweight & Optimized**: Minimal footprint, designed for high-TPS Paper/Purpur/Spigot 1.20+ servers.

---

## 📋 Requirements

- **Java**: `17` or higher
- **Server Software**: Paper, Purpur, Spigot, or compatible forks
- **Minecraft Version**: `1.20.x` (API: `1.20.4`)

---

## 📥 Installation

1. Download the latest `.jar` from the [Releases](https://github.com/) page (or build it yourself from source).
2. Place the `.jar` file into your server's `plugins/` directory.
3. Start or restart your server.
4. Customize `plugins/localhost-customhity/config.yml` to fit your server's needs.

---

## 🛠️ Commands & Permissions

### Commands

| Command | Description | Permission |
| :--- | :--- | :--- |
| `/customhity set <multiplier>` | Sets the player damage multiplier (e.g. `1.5`, `2.0`) and saves it to configuration | `customhity.admin` |
| `/customhity reload` | Reloads `config.yml` configuration and messages | `customhity.admin` |

### Permissions

| Permission | Description | Default |
| :--- | :--- | :--- |
| `customhity.admin` | Grants access to all `/customhity` administrative commands and tab-completion | `op` |

---

## ⚙️ Configuration (`config.yml`)

```yaml
# =======================================================
#               localhost-customhity Config
# =======================================================

# Plugin messages (Supports standard '&' color codes)
messages:
  no-permission: "&cYou don't have permission to do this!"
  usage: "&7Usage: &f/customhity <set/reload>"
  multiplier-set: "&aDamage multiplier set to &e%multiplier%"
  reload: "&aConfiguration reloaded successfully!"
  only-player: "&cThis command can only be executed by players!"

# Main settings
settings:
  # Base damage multiplier (1.0 = default vanilla damage, 1.5 = 150% damage, 2.0 = double damage)
  damage-multiplier: 1.0
```

---

## 🔨 Building from Source

To compile the plugin manually:

### Prerequisites
- JDK 17+ installed
- Apache Maven installed

### Build Steps
```bash
# Clone the repository
git clone https://github.com/your-username/localhost-customhity.git

# Navigate into the project folder
cd localhost-customhity

# Build the shaded JAR
mvn clean package
```

The compiled JAR will be located in the `target/` directory:
```
target/localhost-customhity-1.0-SNAPSHOT.jar
```

---

## 👤 Author & Support

- **Author**: Localhost
- **Discord**: `localhost_127001`

Feel free to open an issue or pull request if you encounter any bugs or have feature requests!
