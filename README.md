# Spigot Reinforcement Plugin
A Spigot Reinforcement Plugin for 1.13 inspired by Civcraft. You can reinforce after enabling the mode using `/reinforce` and right clicking on the blocks.

# File format
The `reinforcement_overworld.srpdata` file is structured as a series of `[x y z strength group_id]` structs encoded in binary taking up 16 bytes of space per block to denote reinforcements. One file exists for each dimension. The groups.srpdata file is a human-readable file just denoting which user belongs to which group.

I did not use any databases at all since since it would have performed worse, and creating a basic fileformat to store block reinforcement data is all you need. At some point the server needs to load all the blocks into memory at once,	or store data according to chunk. 100,000 blocks reinforced only takes up 1.52mb of space so it'd take roughly 6.8 million blocks to take up a gigabyte. The main problem lies in the time it takes to load all this data off disk and into memory. I do not imagine that this many reinforcements will exist.

I'm not so sure that each Reinforcement object loaded in from memory is in fact 16 bytes, but we'll have to make do.. :(