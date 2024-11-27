# Changelog

## [4.2.0] - 2024-11-27

### Added

- added respective caterium armor and tools

### Changed

- updated creative tab implementation
- some tools now using proper swing hand animation when used
- emerald armor now used luck modifier instead of luck potion
- slime armor no longer has knockback resistance
- liquid death got replaced by simply death to prevent crashing with thaumcraft
- updated texture of fire and skull wand
- updated travellers leather texture

### Fixed

- fixed some crafting recipes that used outdated oredict names
- fixed server crash when equipping armor with custom attribute modifier
- fixed crashed related to text translation on a server when items print a chat component to the chat
- fixed server crash when using fire and skull wand

### Removed

- removed legacy shield assets

## [4.1.0] - 2024-06-09

### Added

- added the crocs from the Minecraft Twitter clip (and the ability to walk on water)
- added 10 bows for all oedldoeld materials
- added Moses staff that splits water
- added Moses blood that heals all your pain (or at least refills your health)
- added magical wood planks
- added potion of flight
- added bottle of milk (splash potion)
- added missing armor effects for kitagawarium and sakurajimarium armor
- added liquid death

### Changed

- fixed that some armor effects were broken due to wrong usage of Forge EventBusSubscriber
- all right-clickable items now have the proper hand swing animation
- frieren staff lightning is now randomly offsetted
- shapeless recipes are now truly shapeless and use oredict (no more shaped fabric)
- fixed that some armor pieces were not enchantable

### Removed

- removed legacy assets
  
## [4.0.0] - 2024-03-03

### 1.12.2 isn't dead, it just took some time

Also check out the other mods that have been updated or released! This is a complete rewrite of the old 2.x version and many things have changed since then. The most significant change is that almost everything that was seen in v3.x for 1.16.5 is more or less included in the release, with lots of extras on top.

### Warning

This version is not compatible with older versions and will not work. Back up your world before the update and enjoy the wave of content.

### Added

- added changelog
- added a bunch of missing armor and tools for all supported resources
- added new effects for armor
- added knockback resistance to some armor types
- added smashbats for all supported resources
- added shears for supported resources
- added enhanced dirt, wood and slime armor and tools
- added travelers and long fall boots
- added wizard hats that store potion effects
- added gamemode chestplate
- added pink güffy jacket
- added four new smashbats with different abilities
- added pork hammer
- added admin tools for kicking and banning players
- added skull and fire wands
- added bedrock breaker
- added fly swatter
- added rocky, explosive and charged snowball
- added new crafting ingredients
- added chainmail
- added four new wands inspired by tv series
- added tooltips for items that have mode and range attributes
- added config options to disable various armor and tools properties
- added 5 new jumppads
  
### Changed

- changed license to MIT
- changed jar naming scheme
- updated shields.io badges
- updated curseforge and github page
- updated logo
- updated dependencies
- oedldoedl armor now requires the whole set to get night vision
- reworked almost all textures to match oedldoedl resources design
- changed nearly all recipes

### Removed

- removed baubles and moved them to oedldoedl curiosity
- removed base cap and moved it to oedldoedl curiosity
- removed now deprecated config options
