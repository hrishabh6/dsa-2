#!/usr/bin/env node
const { execSync } = require("child_process");

const args = process.argv;
const msgIndex = args.indexOf("-m");

if (msgIndex === -1 || !args[msgIndex + 1]) {
    console.error("❌ Commit message is required. Usage: node script.js -m \"your message\"");
    process.exit(1);
}

const commitMessage = args[msgIndex + 1];

try {
    console.log("🔹 Adding changes...");
    execSync("git add .", { stdio: "inherit" });

    console.log(`🔹 Committing with message: "${commitMessage}"`);
    execSync(`git commit -m "${commitMessage}"`, { stdio: "inherit" });

    console.log("🔹 Pushing to remote...");

    try {
        execSync("git push", { stdio: "inherit" });
    } catch (pushError) {
        // If push fails due to missing upstream, set it automatically
        console.log("ℹ️ No upstream branch found. Setting upstream...");
        const currentBranch = execSync("git rev-parse --abbrev-ref HEAD").toString().trim();
        execSync(`git push --set-upstream origin ${currentBranch}`, { stdio: "inherit" });
    }

    console.log("✅ All done!");
} catch (error) {
    console.error("❌ An error occurred during git operations.");
    process.exit(1);
}
